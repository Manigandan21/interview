package com.interview.kone.equipment.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloudant.client.api.Database;
import com.cloudant.client.api.model.Response;
import com.interview.kone.equipment.model.Equipment;

@RestController
@RequestMapping("/equipment")
public class EqipmentController {

	@Autowired
	private Database db;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Equipment> getAll() throws IOException {
		List<Equipment> allDocs = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Equipment.class);
		return allDocs;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/search")
	public @ResponseBody List<Equipment> getLimit(@RequestParam("limit") String limit) throws IOException {
		List<Equipment> allDocs = db.getAllDocsRequestBuilder().limit(Integer.parseInt(limit)).includeDocs(true).build().getResponse().getDocsAs(Equipment.class);
		return allDocs;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Equipment getEquipment(@PathVariable String id) throws IOException {
		Equipment equipment = db.find(Equipment.class, id);
		return equipment;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String add(@RequestBody Equipment equipment) {
		Response response = db.post(equipment);
		String id = response.getId();
		return id;
	}
}