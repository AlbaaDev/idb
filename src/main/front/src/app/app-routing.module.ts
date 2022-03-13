import {HomeComponent} from './pages/home/home.component';
import {ResetPasswordComponent} from './pages/reset-password/reset-password.component';
import {SignUpComponent} from './pages/sign-up/sign-up.component';
import {LoginComponent} from './pages/login/login/login.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SettingsComponent} from './pages/settings/settings.component';
import {CardsComponent} from "./pages/cards/cards.component";
import {SendMoneyComponent} from "./pages/send-money/send-money.component";
import {PageNotFoundComponent} from "./pages/page-not-found/page-not-found.component";
import {AuthGuard} from "./_helpers/auth-guard.service";
import {AccountComponent} from "./pages/account/account.component";
import {MainComponent} from "./pages/main/main.component";
import {MarketComponent} from "./pages/market/market.component";
import {VaultComponent} from "./pages/vault/vault.component";

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignUpComponent},
  {path: 'home', component: HomeComponent},
  {path: 'reset', component: ResetPasswordComponent},
  {
    path: 'account', component: AccountComponent, canActivate: [AuthGuard],
    children: [
      {path: '', component: MainComponent, canActivate: [AuthGuard]},
      {path: 'main', component: MainComponent, canActivate: [AuthGuard]},
      {path: 'send', component: SendMoneyComponent, canActivate: [AuthGuard]},
      {path: 'cards', component: CardsComponent, canActivate: [AuthGuard]},
      {path: 'market', component: MarketComponent, canActivate: [AuthGuard]},
      {path: 'vault', component: VaultComponent, canActivate: [AuthGuard]},
      {path: 'settings', component: SettingsComponent, canActivate: [AuthGuard]},
    ]
  },
  {path: '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes), RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
