package org.example.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ScheduleItem {

    private final Course course;
    private final Teacher teacher;
    private final Group group;
    private final DayOfWeek dayOfWeek;
    private final LocalTime time;

    private ScheduleItem(Builder builder) {
        this.course = builder.course;
        this.teacher = builder.teacher;
        this.group = builder.group;
        this.dayOfWeek = builder.dayOfWeek;
        this.time = builder.time;
    }

    @Override
    public String toString() {
        return "ScheduleItem{" +
                "course=" + course +
                ", teacher=" + teacher +
                ", group=" + group +
                ", day=" + dayOfWeek +
                ", time=" + time +
                '}';
    }

    // 🔴 BUILDER
    public static class Builder {

        private Course course;
        private Teacher teacher;
        private Group group;
        private DayOfWeek dayOfWeek;
        private LocalTime time;

        public Builder course(Course course) {
            this.course = course;
            return this;
        }

        public Builder teacher(Teacher teacher) {
            this.teacher = teacher;
            return this;
        }

        public Builder group(Group group) {
            this.group = group;
            return this;
        }

        public Builder dayOfWeek(DayOfWeek dayOfWeek) {
            this.dayOfWeek = dayOfWeek;
            return this;
        }

        public Builder time(LocalTime time) {
            this.time = time;
            return this;
        }

        public ScheduleItem build() {
            return new ScheduleItem(this);
        }
    }
}