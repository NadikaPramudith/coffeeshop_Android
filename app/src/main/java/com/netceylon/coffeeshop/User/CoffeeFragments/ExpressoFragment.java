package com.netceylon.coffeeshop.User.CoffeeFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.netceylon.coffeeshop.R;
import com.netceylon.coffeeshop.User.MainFragments.CoffeeDetailsFragment;
import com.netceylon.coffeeshop.User.MainFragments.HomeFragment;
import com.netceylon.coffeeshop.User.MainFragments.SpecialOffersFragment;
import com.netceylon.coffeeshop.User.UserActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExpressoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExpressoFragment extends Fragment {

    ImageView imageView;
    ImageView imageView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expresso, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.addIcon1);

        imageView.setOnClickListener(v -> {
            if (getActivity() instanceof UserActivity) {
                UserActivity activity = (UserActivity) getActivity();
                CoffeeDetailsFragment coffeeDetailsFragment = CoffeeDetailsFragment.newInstance(
                        R.drawable.hotespressodetailed,
                        "Hot espresso",
                        "Premium Toasted",
                        "Whole milk",
                        "Savor the deep, bold essence of our Hot Espresso, a rich and aromatic brew crafted for true coffee lovers. Each sip is a smooth, invigorating experience, perfectly balancing intensity and warmth, making it the ultimate pick-me-up for espresso enthusiasts seeking pure coffee bliss."
                );
                activity.setBottomNavigationVisibility(false);
                activity.navigateToFragment(coffeeDetailsFragment, R.id.specialOffersFragment);
            }

            // Deselect bottom nav items
            BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottomNavigationView);
            bottomNavigationView.getMenu().setGroupCheckable(0, true, false);
            for (int i = 0; i < bottomNavigationView.getMenu().size(); i++) {
                bottomNavigationView.getMenu().getItem(i).setChecked(false);
            }
            bottomNavigationView.getMenu().setGroupCheckable(0, true, true);
        });
        imageView2 = view.findViewById(R.id.addIcon2);
        imageView2.setOnClickListener(v -> {
            if (getActivity() instanceof UserActivity) {
                UserActivity activity = (UserActivity) getActivity();
                CoffeeDetailsFragment coffeeDetailsFragment = CoffeeDetailsFragment.newInstance(
                        R.drawable.americanodetailed,
                        "Americano",
                        "Premium Toasted",
                        "Whole milk",
                        "Enjoy the crisp, smooth taste of our Americano, a perfectly balanced blend of rich espresso and hot water. Each sip delivers a bold yet mellow flavor, highlighting the deep, aromatic essence of coffee, making it the ideal choice for those who appreciate a pure, invigorating brew."
                );
                activity.setBottomNavigationVisibility(false);
                activity.navigateToFragment(coffeeDetailsFragment, R.id.specialOffersFragment);
            }
        });
    }
}