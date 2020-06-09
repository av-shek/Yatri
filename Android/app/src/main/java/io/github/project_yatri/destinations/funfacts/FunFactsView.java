package io.github.project_yatri.destinations.funfacts;

import java.util.ArrayList;

import objects.FunFact;



interface FunFactsView {
    void showProgressDialog();
    void hideProgressDialog();
    void setupViewPager(ArrayList<FunFact> factsArray);
}
