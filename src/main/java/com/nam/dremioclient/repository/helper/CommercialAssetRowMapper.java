package com.nam.dremioclient.repository.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nam.dremioclient.domain.CommercialAsset;
import com.nam.dremioclient.utils.DremioClientQueryConstants;

/**
 * @author Namrata_Kumari
 *
 */
public class CommercialAssetRowMapper implements RowMapper<CommercialAsset> {

	/**
	 *
	 */
	@Override
	public CommercialAsset mapRow(ResultSet rs, int rowNum) throws SQLException {

		return CommercialAsset.builder()		
				.assetId(rs.getString(DremioClientQueryConstants.COL_ASSET_ID))
				.accountId(rs.getString(DremioClientQueryConstants.COL_ACCNT_ID))
				.groupId(rs.getString(DremioClientQueryConstants.COL_GROUP_ID))
				.expiryDate(rs.getString(DremioClientQueryConstants.COL_CNTRCT_END_DATE))
				.sacVersion(rs.getString(DremioClientQueryConstants.COL_SAC_VERSION))
				.siteId(rs.getString(DremioClientQueryConstants.COL_SITE_ID))
				.warrantyCode(rs.getString(DremioClientQueryConstants.COL_WARRANTY_CODE))
				.region(rs.getString(DremioClientQueryConstants.COL_REGION))
				.modelNumber(rs.getString(DremioClientQueryConstants.COL_WARRANTY_CODE))
				.osName(rs.getString(DremioClientQueryConstants.COL_OS_NAME))
				.prodLine(rs.getString(DremioClientQueryConstants.COL_PRODUCT_LINE))
				.prodLob(rs.getString(DremioClientQueryConstants.COL_PRODUCT_LOB))
				.age(rs.getString(DremioClientQueryConstants.COL_PC_AGE))
				.build();		
	}
}
