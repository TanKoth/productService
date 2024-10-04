package org.productservice.service.searchService.filterService;

public class FilterFactory {

    public static Filter getFilterFromKey(String key){
        return switch (key){
            case "ram" -> new RamFilter();
            case "brand" -> new BrandFilter();
            default -> null;
        };
    }
}
