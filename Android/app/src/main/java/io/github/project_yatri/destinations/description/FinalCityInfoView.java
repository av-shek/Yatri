package io.github.project_yatri.destinations.description;

import java.util.ArrayList;


interface FinalCityInfoView {
    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void showProgress();

    void parseResult(String iconUrl,
                     int code,
                     String temp,
                     String humidity,
                     String weatherInfo);

    void parseInfoResult(String description,
                         String latitude,
                         String longitude,
                         ArrayList<String> imagesArray);

    void networkError();
}
