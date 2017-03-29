package org.kawakicchi.dev.tools.sample.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;

@Dao
@ConfigAutowireable
public interface SampleDao {

	@Insert
	Result<TmSample> insert(TmSample sample);
}
