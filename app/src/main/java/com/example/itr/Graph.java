package com.example.itr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.PointsGraphSeries;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.DefaultLabelFormatter;

import android.graphics.Canvas;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
  {@link Graph.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Graph#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Graph extends Fragment {

    double xdata =0;
    double ydata =0.0;
    boolean testVal=false;
    View view;

    private static final String tag= "Graph";
    PointsGraphSeries<DataPoint> xySeries;
    GraphView tempScatter;

    public Graph() {
        // Required empty public constructor
    }


    public static Graph newInstance(String param1, String param2) {
        Graph fragment = new Graph();
        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //tempScatter = (GraphView)getActivity().findViewById(R.id.tScatter);  // this is wrong fix later
        //tempScatter.setTitle("Tempature over Time");
        createScatter();
    }

    private void createScatter() {
        Log.d("createScatter","this creates the scatter plot");
        xySeries = new PointsGraphSeries<>();




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_graph,container,false );
        tempScatter=view.findViewById(R.id.tScatter);
        tempScatter.getViewport().setYAxisBoundsManual(true);
        tempScatter.getViewport().setXAxisBoundsManual(true);
        tempScatter.getViewport().setMaxY(105);
        tempScatter.getViewport().setMinY(95);
        tempScatter.getViewport().setMinX(0);
        tempScatter.getViewport().setMaxX(10);
        return view;

    }


    public void receiveElement(double d){
        TextView text = getView().findViewById(R.id.testT);
        text.setText("test "+d);
        ydata= d;
        tempScatter.removeAllSeries();
        xySeries.appendData(new DataPoint(xdata, ydata), true, 100);
        Log.d("relement",xySeries.toString());
        xdata++;
        tempScatter.setTitle("Temperture Vs Time");

        tempScatter.getViewport().setMinX(0);
        tempScatter.getViewport().setMaxX(xdata+1);

        Log.d("is this broke",tempScatter.getTitle());
        tempScatter.addSeries(xySeries);


    }
}
