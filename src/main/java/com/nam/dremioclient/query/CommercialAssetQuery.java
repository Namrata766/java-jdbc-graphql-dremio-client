package com.nam.dremioclient.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.nam.dremioclient.domain.CommercialAsset;
import com.nam.dremioclient.service.CommercialAssetService;

/**
 * @author Namrata_Kumari
 * 
 * This is a query resolver class for GraphQL
 *
 */
@Component
public class CommercialAssetQuery implements GraphQLQueryResolver {

	@Autowired
	CommercialAssetService caService;
	
	public List<CommercialAsset> getCommercialAssets() throws Exception {
        return this.caService.getAllAssets();
    }

    public CommercialAsset getCommercialAsset(String assetId) throws Exception {
        return this.caService.getAssetById(assetId);
    }
}
