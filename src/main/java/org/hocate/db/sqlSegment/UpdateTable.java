package org.hocate.db.sqlSegment;

import org.hocate.db.SQLBuilder;

public class UpdateTable extends SingleTable {
	public UpdateTable(SQLBuilder builder) {
		super(builder);
	}

	public Sets table(String table){
		this.table = table;
		builder.setSets(new Sets(builder));
		return builder.getSets();
	}
}