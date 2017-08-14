package com.example.dkdk6.seoullaw.Activity;

import android.media.Image;

/**
 * Created by dkdk6 on 2017-08-14.
 */

public class TalkData {
    Image image;
    String name;
    String company;
    String profile;

    public TalkData(Image r, String Rname, String Rcompany, String Rprofile) {
        image = r;
        name = Rname;
        company = Rcompany;
        profile = Rprofile;
    }
}
