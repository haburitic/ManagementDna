package com.proyect.management.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.management.dto.StatisticsDTO;
import com.proyect.management.interfaces.IDnaStatistics;
import com.proyect.management.repository.InfoAdnDao;

/**
 * service DnaStatistics.
 * @author HABUR
 *
 */
@Service
public class DnaStatisticsServiceImpl implements  IDnaStatistics{
	
	@Autowired
	private InfoAdnDao infoAdnDao;

	@Override
	public StatisticsDTO process() {
		
		Double sumResponse = infoAdnDao.findAllSumDnaStatistics();
		Double countResponse = infoAdnDao.findAllCountDnaStatistics();
		
		Double ratio = runDivision(sumResponse, countResponse);
		BigDecimal formatNumber = new BigDecimal(ratio);
		formatNumber = formatNumber.setScale(1, RoundingMode.UP);
		return new StatisticsDTO(countResponse.intValue(),sumResponse==null?0:sumResponse.intValue(),formatNumber.toString());
	}

	private double runDivision(Double sumResponse, Double countResponse) {
		if(Double.compare(0, countResponse)==0) {
			return 0;
		}
		return countResponse/sumResponse;
	}

}
