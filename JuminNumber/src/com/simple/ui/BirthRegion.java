package com.simple.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BirthRegion implements ActionListener {
	
	InfoPanel infoPanel;
	ResultPanel resultPanel;

	public BirthRegion(InfoPanel infoPanel, ResultPanel resultPanel) {		
		this.infoPanel = infoPanel;
		this.resultPanel = resultPanel;		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String region =infoPanel.tfID2.getText();		
		region = region.substring(1, 3);
		region = getRegion(region);
		System.out.println(region);
		
		resultPanel.tfResult.setText(region);
	}

	private String getRegion(String region) {
		
		int code = Integer.parseInt(region);
		
		if(code>=93 && code <= 95) {
			region = "제주특별시";
		}else if (code==85) {
			region = "울산광역시";			
		}else if (code>=82 && code <= 84 || code>=86 && code <= 92 ) {
			region = "경상남도";			
		}else if (code>=70 && code <= 75 || code>=77 && code <= 81 ) {
			region = "경상북도";			
		}else if (code>=67 && code <= 69) {
			region = "대구";			
		}else if (code>=65 && code <= 66) {
			region = "광주광역시";			
		}else if (code>=55 && code <= 64) {
			region = "전라남도";			
		}else if (code>=48 && code <= 54) {
			region = "전라북도";			
		}else if (code==96 || code == 44) {
			region = "세종특별자치시";				
		}else if (code>=42 && code <= 43 || code>=45 && code <= 47) {
			region = "충청남도";
		}else if (code>=40 && code <= 41) {
			region = "대전광역시";
		}else if (code>=35 && code <= 39) {
			region = "충청북도";
		}else if (code>=26 && code <= 34) {
			region = "강원도";
		}else if (code>=16 && code <= 25) {
			region = "경기도";
		}else if (code>=13 && code <= 15) {
			region = "인천광역시";
		}else if (code>=9 && code <= 12 ) {
			region = "부산광역시";
		}else if (code>=00 && code <= 8) {
			region = "서울특별시";
		}
		
		return region;
	}

}
