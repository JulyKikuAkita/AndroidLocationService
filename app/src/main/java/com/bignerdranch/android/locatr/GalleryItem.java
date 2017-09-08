package com.bignerdranch.android.locatr;

import android.net.Uri;

public class GalleryItem {
    private String mCaption;
    private String mId;
    private String mUrl;
    private String mOwner;
    private double mLat;
    private double mLon;

    @Override
    public String toString() {
        return mCaption;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public double getLon() {
        return mLon;
    }

    public void setLon(double lon) {
        mLon = lon;
    }

    /**
     Look at the “Web Page URLs” section of Flickr’s documentation at www.flickr.com/services/api/misc.urls.html,
     you will see that you can create the URL for an individual photo’s page like so:
     https://www.flickr.com/photos/user-id/photo-id
     The photo-id seen here is the same as the value of the id attribute from your JSON.
     You are already stashing that in mId in GalleryItem. What about user-id?
     If you poke around the documentation, you will find that the owner attribute in your JSON is a user ID.
     So if you pull out the owner attribute, you should be able to build the URL from your photo JSON:
     https://www.flickr.com/photos/owner/id
     * @return
     */
    public Uri getPhotoPageUri() {
        return Uri.parse("https://www.flickr.com/photos/")
                .buildUpon()
                .appendPath(mOwner)
                .appendPath(mId)
                .build();
    }
}
