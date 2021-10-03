public class Clock {

    private int hr;
    private int min;
    private int sec;

    public Clock() {

        setTime(0, 0, 0);

    }


    public Clock (int hours, int minutes, int seconds)
    {

        setTime(hours, minutes, seconds);
    }

    private void setTime(int hours, int minutes, int seconds)
    {
        if( 0<= hours && hours < 24)
            hr = hours;
        else
            hr = 0;

        if (0 <= minutes && minutes < 60)
            min = minutes;
        else
            min = 0;

        if (0 <= seconds && seconds < 60)
            sec = seconds;
        else
            sec = 0;
    }

    public int getHours()
    {
        return hr;
    }

    public int getMinutes()
    {
        return min;
    }

    public int getSeconds()
    {
        return sec;
    }



    public String returnTime()
    {
        String chours;
        String cmins;
        String csecs;

        String currentTime;

        if (hr < 10)
            chours = ("0" + Integer.toString(hr));
        else
            chours = Integer.toString(hr);

        if (min < 10)
            cmins = ("0" + Integer.toString(min));
        else
            cmins = Integer.toString(min);


        if (sec < 10)
            csecs = ("0" + Integer.toString(sec));
        else
            csecs = Integer.toString(sec);


        currentTime =(chours + ":" + cmins + ":" + csecs);

        System.out.println(currentTime);
        return currentTime;
    }

    public void printTime()
    {
        String chours;
        String cmins;
        String csecs;

        String currentTime;

        if (hr < 10)
            chours = ("0" + Integer.toString(hr));
        else
            chours = Integer.toString(hr);

        if (min < 10)
            cmins = ("0" + Integer.toString(min));
        else
            cmins = Integer.toString(min);


        if (sec < 10)
            csecs = ("0" + Integer.toString(sec));
        else
            csecs = Integer.toString(sec);


        currentTime =(chours + ":" + cmins + ":" + csecs);

        System.out.println("The current time is : " + currentTime);

    }




    public void incrementSeconds()
    {
        sec++;
        if (sec>59) {
            sec = 0;
            incrementMinutes();
        }
    }

    public void incrementMinutes()
    {
        min++;
        if (min > 59) {
            min = 0;
            incrementHours();
        }
    }

    public void incrementHours()
    {
        hr++;

        if (hr > 23)
            hr = 0;

    }

}
