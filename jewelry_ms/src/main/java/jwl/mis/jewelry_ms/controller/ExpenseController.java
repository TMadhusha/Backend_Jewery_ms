package jwl.mis.jewelry_ms.controller;

import jwl.mis.jewelry_ms.exception.ExpenseNotFoundException;
import jwl.mis.jewelry_ms.model.Expense;
import jwl.mis.jewelry_ms.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ExpenseController {
    @Autowired
    private ExpenseRepository expenseRepository;

    @PostMapping("/addExpense")
    Expense newExpense(@RequestParam (value = "receipt", required = false) MultipartFile receipt,
                       @RequestParam ("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
                       @RequestParam ("description") String description,
                       @RequestParam ("type") String type,
                       @RequestParam ("amount") double amount){
        Expense newExpense=new Expense();
        newExpense.setDate(date);
        newExpense.setDescription(description);
        newExpense.setType(type);
        newExpense.setAmount(amount);
        if (receipt != null) {
            try {
                newExpense.setReceipt(receipt.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return expenseRepository.save(newExpense);
    }

    @GetMapping("/getExpense")
    List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    @GetMapping("/getExpenseById/{expenseId}")
    Expense getById(@PathVariable Long expenseId){
        return expenseRepository.findById(expenseId)
                .orElseThrow(()->new ExpenseNotFoundException(expenseId));
    }

    @PutMapping("/updateExpenseById/{expenseId}")
    Expense updateExpense(@RequestBody Expense newExpense, @PathVariable Long expenseId){
        try{
            //Fetch the existing expense
            Expense existingExpense=expenseRepository.findById(Long.valueOf(expenseId))
                    .orElseThrow(()->new ExpenseNotFoundException(expenseId));

            //Update expense
            existingExpense.setDescription(newExpense.getDescription());
            existingExpense.setType(newExpense.getType());
            existingExpense.setAmount(newExpense.getAmount());

            return expenseRepository.save(existingExpense);
        } catch (ExpenseNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/deleteExpense/{expenseId}")
    String deleteExpense(@PathVariable Long expenseId){
        if(!expenseRepository.existsById(expenseId)){
            throw new ExpenseNotFoundException(expenseId);
        }
        expenseRepository.deleteById(expenseId);
        return "Cart item with id "+ expenseId +" has been deleted sucessfully";
    }
}
