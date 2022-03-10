package com.nam.dremioclient.repository.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nam.dremioclient.domain.CommercialAsset;
import com.nam.dremioclient.repository.CommercialAssetDremioRepository;
import com.nam.dremioclient.repository.helper.CommercialAssetRowMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Namrata_Kumari
 *
 */
@Repository
@Slf4j
public class CommercialAssetDremioRepositoryImpl implements CommercialAssetDremioRepository {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	/**
	 * To fetch commercial asset details for the given asset ID.
	 */
	@Override
	public CommercialAsset getAssetById(String assetId) throws Exception {
		
		//SqlParameterSource params = new MapSqlParameterSource().addValue("ASSET_ID", assetId);
		/*
		 * Prepared statements are not yet supported by Dremio JDBC Driver. Hence, using String concatenation.
		 * Input needs to be sanitized well for real business scenarios.
		 */
		
		try {
			String query = String.format(FETCH_COMMERCIAL_ASSETS_FOR_ID, "'" + assetId + "'");
			log.info("Query to select assets : {}", query);
			
			return jdbcTemplate.queryForObject(query, new HashMap<>(), new CommercialAssetRowMapper());
		} catch (EmptyResultDataAccessException e) {
			log.error("Asset not fround in Data source", e);
			return CommercialAsset.builder().assetId(assetId).error("Asset not fround in Data source").build();
		}
	}

	/**
	 * To fetch a list of commercial assets.
	 */
	@Override
	public List<CommercialAsset> getAssets() throws Exception {
		return jdbcTemplate.query(FETCH_COMMERCIAL_ASSETS, new CommercialAssetRowMapper());
	}
}
