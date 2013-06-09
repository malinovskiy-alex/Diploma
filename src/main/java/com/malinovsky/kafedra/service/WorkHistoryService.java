package com.malinovsky.kafedra.service;

import java.util.List;

import com.malinovsky.kafedra.model.WorkHistory;

public interface WorkHistoryService {
	List<WorkHistory> generateMonthHistory();
}
