import React,{useState} from 'react';
import axios from 'axios';

export default function Cadastro({history}) {
  const[cpf,setCpf]=useState('');
  const[nome,setNome]=useState('');
  const[endereco,setEndereco]=useState('');

  async function cadastrar(){
    const result = await axios.post('http://localhost:3333/cliente',{
      cpf,
      nome,
      endereco
    })
    await localStorage.setItem('BibliotecaFC',JSON.stringify(result.data))
    history.push('/lista')
    }


  function handlecpf(e){
    setCpf(e.target.value);
  }
  function handleEndereco(e){
    setEndereco(e.target.value);
  }
  function handleNome(e){
    setNome(e.target.value);
  }

  return (
    <div className='pageContainer'>
        <div className='login'>
            <h2>Nome</h2>
            <input className='input' type='text' placeholder='Nome' onChange={handleNome} />
            <h2>Cpf</h2>
            <input className='input' type='text' placeholder='CPF' onChange={handlecpf}/>
            <h2>Endereço</h2>
            <input className='input' type='text' placeholder='Endereço' onChange={handleEndereco}/>
            <button onClick={cadastrar} className='button'>
              Cadastrar
            </button>
        </div>
    </div>
  );
}
