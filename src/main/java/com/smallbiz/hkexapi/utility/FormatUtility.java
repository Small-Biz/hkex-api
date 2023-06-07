package com.smallbiz.hkexapi.utility;

import org.apache.commons.lang3.StringUtils;

public class FormatUtility {

	public static String fullInstrumentCode(int instrumentCode) {
		return String.format("%05d", instrumentCode);
	}

	public static String fullInstrumentCode(String instrumentCode) {
		return StringUtils.leftPad(instrumentCode, 5, "0");
	}
	
}
