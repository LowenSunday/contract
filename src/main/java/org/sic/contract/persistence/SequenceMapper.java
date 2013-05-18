package org.sic.contract.persistence;

import java.util.Map;

public interface SequenceMapper {
	Long getId(String sequenceName);
	
	void setId(Map<String,Long> params);
}
