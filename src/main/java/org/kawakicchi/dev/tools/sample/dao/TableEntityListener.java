package org.kawakicchi.dev.tools.sample.dao;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PostInsertContext;
import org.seasar.doma.jdbc.entity.PreInsertContext;

public class TableEntityListener implements EntityListener<TmSample> {

	public void preInsert(TmSample entity, PreInsertContext<TmSample> context) {
		System.out.println(context.getConfig().getDialect());
	}

	public void postInsert(TmSample entity, PostInsertContext<TmSample> context) {
		System.out.println(entity.getSeq());
	}
}