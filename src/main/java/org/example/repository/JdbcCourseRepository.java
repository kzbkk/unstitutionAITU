package org.example.repository;

import org.example.config.DBConnection;
import org.example.domain.Course;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
public class JdbcCourseRepository implements CourseRepository {

    @Override
    public void save(Course course) {
        String sql = "INSERT INTO courses (id, title, teacher_name) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, course.getId());
            ps.setString(2, course.getTitle());
            ps.setString(3, course.getTeacherName());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Course> findById(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return Optional.of(new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("teacher_name")
                ));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> findAll() {
        List<Course> result = new ArrayList<>();
        String sql = "SELECT * FROM courses";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                result.add(new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("teacher_name")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM courses WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(int id, Course course) {
        String sql = "UPDATE courses SET title = ?, teacher_name = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, course.getTitle());
            ps.setString(2, course.getTeacherName());
            ps.setInt(3, id);

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}