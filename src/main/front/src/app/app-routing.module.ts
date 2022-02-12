import { HomeComponent } from './pages/home/home.component';
import { ResetPasswordComponent } from './pages/reset-password/reset-password.component';
import { DashboardComponent } from './pages/dashboard/dashboard/dashboard.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { LoginComponent } from './pages/login/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SettingsComponent } from './pages/settings/settings.component';
import {TransactionsComponent} from "./pages/transactions/transactions.component";
import {CardsComponent} from "./pages/cards/cards.component";

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignUpComponent},
  {path: 'home', component: HomeComponent},
  {
    path: 'dashboard', component: DashboardComponent,
    children: [
      {path: 'settings', component: SettingsComponent},
      {path: 'transactions', component: TransactionsComponent},
      {path: 'cards', component: CardsComponent},
    ]
  },
  {path: 'reset', component: ResetPasswordComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
