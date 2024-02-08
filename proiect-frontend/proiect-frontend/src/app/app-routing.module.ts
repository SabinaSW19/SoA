
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AddBookComponent} from './add-book/add-book.component';
import {LoginComponent} from "./login/login.component";


const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full' },
  {path: 'login', component: LoginComponent},
  {path: 'add-book', component: AddBookComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {scrollPositionRestoration: 'enabled'})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
