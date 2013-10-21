package com.daeheehan.lrucache.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.daeheehan.lrucache.LruCacheApplication;
import com.daeheehan.lrucache.R;

public class ImageArrayAdapter extends ArrayAdapter<String> {
	private static final String CNAME = ImageArrayAdapter.class.getSimpleName();

	private List<String> mValues = new ArrayList<String>();
	private Context context;

	public ImageArrayAdapter(Context context, int resource, List<String> values) {
	      super(context, resource, values);
	      this.context = context;
	      this.mValues = values;
	}

	@Override
	public int getCount() {
    	return mValues.size();
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		ImageViewHolder viewHolder;
		
		if(v == null) {
			LayoutInflater li = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.image_row, parent, false);
			viewHolder = new ImageViewHolder();
			
			viewHolder.imgIcon = (ImageView) v.findViewById(R.id.icon);
			viewHolder.txtIcon = (TextView) v.findViewById(R.id.description);
			
			v.setTag(viewHolder);
		} else {
			viewHolder = (ImageViewHolder) v.getTag();
		}
		
		String name = mValues.get(position);
		viewHolder.txtIcon.setText(name);
		
		Bitmap icon = null;
		Resources res = context.getResources();
		if(name.equalsIgnoreCase("google")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.google);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}

		} else if(name.equalsIgnoreCase("gmail")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.gmail);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}

		} else if(name.equalsIgnoreCase("gtalk")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.gtalk);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("skype")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.skype);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("youtube")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.youtube);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("ebay")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.ebay);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("linkedin")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.linkedin);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("twitter")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.twitter);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("facebook")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.facebook);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else if(name.equalsIgnoreCase("yahoo")) {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.yahoo);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		} else {
			icon = LruCacheApplication.getApplicationBitmapFromCache(name);
			if(icon == null) {
				icon = BitmapFactory.decodeResource(res, R.drawable.no_service);
				LruCacheApplication.addApplicationImageToCache(name, icon);
			}
			
		}  
 
		viewHolder.imgIcon.setImageBitmap(icon);
		
		return v;
	}

	static class ImageViewHolder {
		ImageView imgIcon;
		TextView txtIcon;
	}
}
