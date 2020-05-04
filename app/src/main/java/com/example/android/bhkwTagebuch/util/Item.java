package com.example.android.bhkwTagebuch.util;

/**
 * {@link Item} represents an Item to be displayed in the fragment layout.
 * It contains Item name, address and an image whether available.
 */
public class Item {

    /** Item Name */
    private String mHouseNumber;

    /** Item  Counter Number*/
    private String mCounterNumber;

    /** Image resource ID for the word */
    private int mImageResourceId;

    /** Item Address */
    private String mAddress;

    /** Item Reference (Bezug) */
    private String mReference = "1.8.0";

    /** Item Delivery (Lieferung) */
    private String mDelivery = "2.8.0";

    /**
     * Create a new Item object.
     *  @param houseNumber is the ...
     * @param counterNumber is the ....
     * @param address is the location of the house
     * @param imageResourceId is the drawable resource ID for the image associated with the item
     */
    public Item(String houseNumber, String counterNumber, String address, int imageResourceId) {
        this.mHouseNumber = houseNumber;
        this.mCounterNumber = counterNumber;
        this.mAddress = address;
        this.mImageResourceId = imageResourceId;
    }

    /**
     * Returns the Item House number
     * @return item mHouseNumber
     */
    public String getHouseNumber() {
        return mHouseNumber;
    }

    /**
     * Returns the Item Counter number
     * @return item mCounterNumber
     */
    public String getCounterNumber() {
        return mCounterNumber;
    }

    /**
     * Return the image resource ID of the item.
     * @return item image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns the Item Address
     * @return item mAddress
     */
    public String getAddress() {
        return mAddress;
    }

    public String getReference() {
        return mReference;
    }

    public String getDelivery() {
        return mDelivery;
    }
}
