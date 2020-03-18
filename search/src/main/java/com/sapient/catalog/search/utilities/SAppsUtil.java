package com.sapient.catalog.search.utilities;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

@Component
public class SAppsUtil {

	
	public boolean isValidLong(String val) {
		try {
			Long.parseLong(val);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<Long> getLongs(List<String> vals) {
		List<Long> longs = new ArrayList<Long>();
		if (CollectionUtils.isEmpty(vals)) 
			return longs;
		vals.stream().forEach((val) -> {
			if (isValidLong(val)) {
				longs.add(Long.valueOf(val));
			}
		});
		return longs;
	}
	
}
