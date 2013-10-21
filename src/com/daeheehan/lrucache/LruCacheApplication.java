package com.daeheehan.lrucache;

import android.app.Application;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.util.Log;

public class LruCacheApplication extends Application {
	public static final String CNAME = LruCacheApplication.class
			.getSimpleName();

	// Memory Cache Size
	public static final int MAX_MEMORY = (int) (Runtime.getRuntime().maxMemory() / 1024);
	public static final int APP_IMAGE_CACHE_SIZE = MAX_MEMORY / 8;

	public static Application app = null;

	// Memory Cache for Application Image
	public static LruCache<String, Bitmap> mApplicationImageMemCache = new LruCache<String, Bitmap>(
			APP_IMAGE_CACHE_SIZE) {
		@Override
		protected int sizeOf(String key, Bitmap bitmap) {
			// The cache size will be measured in bytes rather than number of item
			return bitmap.getByteCount() / 1024;
		}
	};

	@Override
	public void onCreate() {
		Log.v(CNAME, "Application onCreate()");

		super.onCreate();
		app = this;
	}

	public static void addApplicationImageToCache(String uniqueId, Bitmap bitmap) {
		if (uniqueId == null || uniqueId.isEmpty() || bitmap == null) {
			return;
		}

		if (getApplicationBitmapFromCache(uniqueId) == null) {
			// Storing Image in the memory
			mApplicationImageMemCache.put(uniqueId, bitmap);
		}

	}

	public static Bitmap getApplicationBitmapFromCache(String uniqueId) {
		if (uniqueId == null || uniqueId.isEmpty()) {
			return null;
		}

		// Getting Image from the memory
		Bitmap b = mApplicationImageMemCache.get(uniqueId);
		if (b != null) {
			return b;
		}

		return null;
	}
}
