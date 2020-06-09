package io.github.project_yatri.utilities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.project_yatri.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutUsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutUsFragment extends Fragment {

    private static final String EMAIL = "avishek.bjf@gmail.com";


    private Context mContext;

    @BindView(R.id.tv_version_code)
    TextView mVersionCode;

    public AboutUsFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment AboutUsFragment.
     */
    public static AboutUsFragment newInstance() {
        AboutUsFragment fragment = new AboutUsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this, view);
        try {
            PackageInfo pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            String version = pInfo.versionName;
            mVersionCode.setText(version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return view;
    }





    @OnClick(R.id.cv_contact_us)
    public void onContactUsClicked() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", EMAIL, null));
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_hello));
        startActivity(Intent.createChooser(intent, getString(R.string.email_send)));
    }



    @OnClick(R.id.cv_report_bug)
    public void onReportBugClicked() {
        Fragment fragment;
        FragmentManager fragmentManager = getFragmentManager();
        fragment = BugReportFragment.newInstance();
        if (fragment != null && fragmentManager != null) {
            fragmentManager.beginTransaction().addToBackStack(null).replace(R.id.inc, fragment).commit();
        }
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
