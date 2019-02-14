package com.example.christopher.drillingassistant;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdpater extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdpater(Context context){
        this.context = context;
    }

    //Sources:
    //Clipboard: <div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" 			    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 			    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
    //Ruler: <div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" 			    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 			    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
    //Compass: <div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" 			    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 			    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
    public int[] slider_images = {

        R.drawable.ruler,
        R.drawable.compass,
        R.drawable.clipboard

    };

    public String[] slider_heading = {

            "BASIC DATA",
            "CALCULATIONS",
            "COMPLETE THE DATA"

    };

    public String[] slider_descriptions = {

            "First you have to enter the dimensions of your worktop. For this purpose, the uppermost section of the input screen is there. Let us know the length and width of your board and, if necessary, the corresponding edge distance.",
            "Choose between 3 different calculation methods:\n\n" +
                    "√ Maximum number of holes,\n" +
                    "√ Largest possible distance between the individual holes or\n" +
                    "√ Largest possible diameter.",
            "According to the choice of the calculation method you now only have to fill in the missing parameters. For this you use the bottom section of the following window."
    };

    @Override
    public int getCount() {
        return slider_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_description);

        slideImageView.setImageResource(slider_images[position]);
        slideHeading.setText(slider_heading[position]);
        slideDescription.setText(slider_descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
