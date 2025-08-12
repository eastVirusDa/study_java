package javaJungSuk_7;

class MyTv2{
    boolean isPowerOn;
    int channel;
    int volume;

    //Exercise7_11
    int prevChannel = 0;

    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 0;

    public boolean getIsPowerOn() {
        return isPowerOn;
    }
    public int getChannel() {
        return channel;
    }
    public int getVolume() {
        return volume;
    }

    public void setIsPowerOn(boolean isPowerOn) {
        this.isPowerOn = !isPowerOn;
    }
    public void setChannel(int channel) {
        // Exercise7_11
        this.prevChannel = this.channel;

        // Exercise7_10
        if(channel<MIN_CHANNEL || channel>MAX_CHANNEL)
        {
            return;
        }
        this.channel = channel;
    }

    public void setVolume(int volume) {
        if(volume<MIN_VOLUME || volume>MAX_VOLUME)
        {
            return;
        }
        this.volume = volume;
    }

    // Exercise7_11
    public void gotoPrevChannel() {
        int temp = this.channel;
        this.channel = this.prevChannel;
        this.prevChannel = temp;
    }
}

public class Exercise7_11 {
    public static void main(String[] args) {
        // Exercise7_10
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH:" + t.getChannel());
        t.setVolume(20);
        System.out.println("VOL:"+ t.getVolume());

        // Exercise7_11
        t.setChannel(10);
        System.out.println("CH:" + t.getChannel());
        t.setChannel(20);
        System.out.println("CH:" + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:" + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH:" + t.getChannel());
    }
}
