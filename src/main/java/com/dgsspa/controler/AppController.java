package com.dgsspa.controler;

import com.dgsspa.Handler;
import com.dgsspa.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {


	@PostMapping("/putitem")
	public Transaction putItem(@RequestBody Transaction trans){
		Handler handler = new Handler();
		Transaction result = handler.putItem(trans);

		return result;
	}

	// @GetMapping(value="/validate/{process}/{status}")
	@GetMapping(value="/validate")
	public List<Transaction> validateStatus(@RequestParam("process") String process, @RequestParam("status") String status){
		Handler handler = new Handler();
		List<Transaction> result = handler.queryTable(process, status);
		System.out.println("RESULT=" + result.get(0));
		return result;
	}
}
