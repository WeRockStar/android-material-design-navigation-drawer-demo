package pattern.we.com.materialdemo1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NavigationDrawerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NavigationDrawerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NavigationDrawerFragment extends Fragment {

    public static final String PRED_FILE_NAME = "testPrefer";
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;


    private boolean userLearnedDrawer;
    private boolean fromSavedInstanceState;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
    }


    public void setUp(DrawerLayout drawerLayout, Toolbar toolbar) {
        this.drawerLayout = drawerLayout;
        drawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout
                , toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        this.drawerLayout.setDrawerListener(drawerToggle);
    }


    public void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PRED_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.commit();
    }
}
