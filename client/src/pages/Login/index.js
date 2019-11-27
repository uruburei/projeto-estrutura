import React,{useState} from 'react';
import './style.css';
import axios from 'axios';

export default function Login({history}) {
  const[cpf,setCpf]=useState('')
  async function logar(){
    const result = await axios.post('http://localhost:3333/cliente/login',{
      cpf
    })
    if(result.data === "Cliente não existe"){
      history.push('/cadastro')
    }else{
      await localStorage.setItem('BibliotecaFC',JSON.stringify(result.data))
      history.push('/lista')
    }
  }
  function handlecpf(e){
    setCpf(e.target.value);
  }
  
  return (
    <div className='pageContainer'>
        <div className='login'>
            <h1 className='titulo'>
                Biblioteca publica
            </h1>
            <input className='input' onChange={handlecpf} type='text' placeholder='CPF' />
            <button onClick={logar} className='button'>
                Entrar/Cadastrar
            </button>
        </div>
    </div>
  );
}
