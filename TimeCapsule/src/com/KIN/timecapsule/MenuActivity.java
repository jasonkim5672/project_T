package com.KIN.timecapsule;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.*;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.*;
import android.widget.Toast;

public class MenuActivity extends Activity {
	Vibrator vib;
	private myview vw;
	ArrayList<Vertex> arVertex;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		vw = new myview(this);
		arVertex = new ArrayList<Vertex>();
		setContentView(vw);
		vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		vib.vibrate(100);
	}

	public class Vertex {
		public Vertex(float ax, float ay, boolean ad) {
			x = ax;
			y = ay;
			Draw = ad;

		}

		float x, y;
		boolean Draw;
	}

	protected class myview extends View {
		Paint mpaint;

		public myview(Context context) {
			super(context);
			mpaint = new Paint();
			mpaint.setColor(Color.GREEN);
			mpaint.setStrokeWidth(3);
			mpaint.setAntiAlias(true);
		}

		public void onDraw(Canvas canvas) {
			canvas.drawColor(Color.LTGRAY);
			for (int i = 0; i < arVertex.size(); i++) {
				if (arVertex.get(i).Draw) {
					canvas.drawLine(arVertex.get(i - 1).x,
							arVertex.get(i - 1).y, arVertex.get(i).x,
							arVertex.get(i).y, mpaint);
				}
			}
		}

		public boolean onTouchEvent(MotionEvent ev) {
			if (ev.getAction() == MotionEvent.ACTION_DOWN) {
				arVertex.add(new Vertex(ev.getX(), ev.getY(), false));
				return true;
			}
			if (ev.getAction() == MotionEvent.ACTION_MOVE) {
				arVertex.add(new Vertex(ev.getX(), ev.getY(), true));
				invalidate();
				return true;

			}
			return false;

		}

	}
}
