package org.kawakicchi.dev.tools.sample.dao;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(immutable = true, naming = NamingType.SNAKE_LOWER_CASE, listener = TableEntityListener.class)
public class TmSample {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Integer seq;
	private final String name;

	public TmSample(Integer seq, String name) {
		super();
		this.seq = seq;
		this.name = name;
	}

	/**
	 * seqのGetter
	 * 
	 * @return seqを返却
	 */
	public Integer getSeq() {
		return seq;
	}

	/**
	 * nameのGetter
	 * 
	 * @return nameを返却
	 */
	public String getName() {
		return name;
	}

}
