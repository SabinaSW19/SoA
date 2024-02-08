import {Component, OnInit} from '@angular/core';
import {Service} from '../shared/service';
import {Router} from '@angular/router';
import {Book} from "../shared/book.model";
import {Review} from "../shared/review.model";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrl: './add-book.component.css'
})
export class AddBookComponent implements OnInit{
  books: Book[] = [];
  reviews: Review[] = [];
  bookList: Book[] = [];
  title: string = "";
  constructor(private service: Service, public router: Router) { }

  ngOnInit(): void {
    let variable = localStorage.getItem("username");
    if(variable == null){
      this.router.navigate(["login"]);
    }
  }

  getBooks(): void {


    this.service.getBooks().subscribe(b => this.bookList = b);

    //this.service.getBooks().subscribe(predictions => { console.log(predictions); this.books =  predictions[0]; });

  }

  getBookByTitle(): void {

    this.service.addBook(this.title).subscribe(bookReturned => { this.books =  bookReturned; });
    console.log(this.books);

  }

  borrowBook(): void {

    this.service.borrowBook(this.title);

  }

  getReviews(): void {

    this.service.getReviews(this.title).subscribe(r => {  this.reviews =  r; });

  }

  logout(): void{
    localStorage.clear();
    this.router.navigate(["login"]);
  }


}
