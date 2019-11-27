import React from 'react';
import {BrowserRouter,Switch,Route} from 'react-router-dom';

import login from './pages/Login/index'
import lista from './pages/Lista/index'
import cadastro from './pages/Cadastro/index'
import doar from './pages/Doar/index'

export default function src() {
  return (
    <BrowserRouter>
        <Switch>
            <Route exact path='/' component={login}/>
            <Route exact path='/lista' component={lista}/>
            <Route exact path='/cadastro' component={cadastro}/>
            <Route exact path='/doar' component={doar}/>
        </Switch>
    </BrowserRouter>
  );
}
