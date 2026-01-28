import java.time.DayOfWeek;
import java.time.LocalTime;

public class Schedule
{
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Classes classes;
    private Trainer trainer;

    public Schedule(DayOfWeek dayOfWeek,  LocalTime startTime,  LocalTime endTime, Trainer trainer, Classes classes)
    {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classes = classes;
    }
}
