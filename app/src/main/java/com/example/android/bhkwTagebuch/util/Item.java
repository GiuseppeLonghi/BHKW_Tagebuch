package com.example.android.bhkwTagebuch.util;

/**
 * {@link Item} represents an Item item.
 * It contains Item name, address and an image whether available.
 */
public class Item {

    /** Item Name */
    private String mName;

    /** Item Address */
    private String mAddress;

    /** Item Description */
    private String mDescription;

    /** Item Category */
    private String mCategory;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /**
     * Create a new Item object.
     *
     * @param name is the name of the item (an item can be an Item, Monument, Restaurant, Event)
     * @param address is the address of the object represented by the item
     * @param imageResourceId is the drawable resource ID for the image associated with the item
     * @param description is the description for the item (description of the Hotel or Restaurant etc.)
     * @param category is the the category of the item (Hotels, Restaurants, Monuments, Events)
     */
    public Item(String name, String address, int imageResourceId, String description, String category) {
        mName = name;
        mAddress = address;
        mImageResourceId = imageResourceId;
        mDescription = description;
        mCategory = category;
    }

    /**
     * Returns the Item name
     * @return item name
     */
    public String getName() {
        return mName;
    }

    /**
     * Returns the Item Address
     * @return item address
     */
    public String getAddress() {
        return mAddress;
    }

    /**
     * Return the image resource ID of the item.
     * @return item image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the description of the item.
     * @return item description
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Return the Category of the item (Hotels, Restaurants, Events, Monuments).
     * @return item category
     */
    public String getCategory() {
        return mCategory;
    }
}
