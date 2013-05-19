package org.sic.contract.persistence;

import org.sic.contract.entity.Sequence;

public interface SequenceMapper {
	Long getId(String sequenceName);
	
	void setId(Sequence sequence);
}
