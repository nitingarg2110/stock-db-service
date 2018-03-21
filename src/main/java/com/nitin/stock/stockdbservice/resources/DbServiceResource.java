package com.nitin.stock.stockdbservice.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitin.stock.stockdbservice.model.Quote;
import com.nitin.stock.stockdbservice.model.Quotes;
import com.nitin.stock.stockdbservice.repository.QuotesRepo;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private QuotesRepo quoteRepo;

	public DbServiceResource(QuotesRepo quoteRepo) {
		super();
		this.quoteRepo = quoteRepo;
	}

	@GetMapping("/{userName}")
	public List<String> getQuotes(@PathVariable("userName") final String userName) {

		return getQuoteByUserName(userName);

	}

	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {

		quotes.getQuotes().stream().forEach(quote -> {
			quoteRepo.save(new Quote(quotes.getUserName(), quote));
		});
		return getQuoteByUserName(quotes.getUserName());

	}

	@PostMapping("/delete/{userName}")
	public List<String> delete(@PathVariable("userName") final String userName) {
		List<Quote> quotes = quoteRepo.findByUserName(userName);
		quotes.stream().forEach(quote -> {
			quoteRepo.delete(quote);
		});

		return getQuoteByUserName(userName);

	}

	private List<String> getQuoteByUserName(final String userName) {
		return quoteRepo.findByUserName(userName).stream().map(Quote::getQuote).collect(Collectors.toList());
	}
}
