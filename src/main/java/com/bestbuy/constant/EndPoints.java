package com.bestbuy.constant;

public class EndPoints {
    /**
     * This is Endpoints of PRODUCTS
     */
    public static final String GET_ALL_PRODUCTS = "";
    public static final String GET_SINGLE_PRODUCT_BY_ID = "/{productID}";
    public static final String UPDATE_PRODUCT_BY_ID = "/{productID}";
    public static final String DELETE_PRODUCT_BY_ID = "/{productID}";


    /**
     * This is Endpoints of STORES
     */

    public static final String GET_SINGLE_STORE_BY_ID = "/{storeID}";
    public static final String UPDATE_STORE_BY_ID = "/{storeID}";
    public static final String DELETE_STORE_BY_ID = "/{storeID}";

    /**
     * This is Endpoints of CATEGORIES
     */

    public static final String GET_SINGLE_CATEGORY_BY_ID = "/{categoryID}";
    public static final String UPDATE_CATEGORY_BY_ID = "/{categoryID}";
    public static final String DELETE_CATEGORY_BY_ID = "/{categoryID}";

    /**
     * This is Endpoints of SERVICES
     */

    public static final String GET_SINGLE_SERVICES_BY_ID = "/{servicesID}";
    public static final String UPDATE_SERVICES_BY_ID = "/{servicesID}";
    public static final String DELETE_SERVICES_BY_ID = "/{servicesID}";

    /**
     * This is Endpoints of UTILITIES
     */

    public static final String GET_VERSION = "/version";
    public static final String GET_HEALTH_CHECK = "/healthcheck";
}
