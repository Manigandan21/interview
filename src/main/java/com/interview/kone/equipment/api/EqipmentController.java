package com.interview.kone.equipment.api;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
/**
 * @author Manigandan Neelakandan
 */
public class EqipmentController {

	@Autowired
	private Database db;
								// Use case 1 - equipment/search?limit={X}
	/**
	 * @param limit
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value="/search")
	public @ResponseBody List<Equipment> getLimit(@RequestParam("limit") String limit) throws IOException {
		List<Equipment> allDocs = db.getAllDocsRequestBuilder().limit(Integer.parseInt(limit)).includeDocs(true).build().getResponse().getDocsAs(Equipment.class);
		return allDocs;
	}
	
								// Use case 2 - equipment/{equipmentNumber}
	/**
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public @ResponseBody Equipment getEquipment(@PathVariable String id) throws IOException {
		Equipment equipment = db.find(Equipment.class, id);
		return equipment;
	}

								// Use case 3 -  equipment  -- POST
	/**
	 * @param equipment
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String add(@RequestBody Equipment equipment) throws ParseException{
		Date date1 = null;
		Date date2 = null;
		String id=null;
			 date1=new SimpleDateFormat("dd/MM/yyyy").parse(equipment.getContractStartDate());
			date2=new SimpleDateFormat("dd/MM/yyyy").parse(equipment.getContractEndDate());
		
		//Checking Start date is before than the end date
		if (date1.compareTo(date2) < 0)
		{
		Response response = db.post(equipment);
		id = response.getId();
		}
		return id;
	}
}