package com.yavoric.lesson10.task1;

public interface Time {
    void setTime(int hours, int minutes, int seconds); // устанавливает значение времени
    String getTime(TimeFormat timeFormat);		// выдает строковое представление
}
