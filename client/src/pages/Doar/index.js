import React,{useState} from 'react';
import axios from 'axios';

export default function Doar({history}) {
  const[quantidadepaginas,setCpf]=useState('');
  const[nome,setNome]=useState('');

  async function doarF(){
    const result = await axios.post('http://localhost:3333/livro',{
      nome,
      quantidadepaginas
    })
     if(result.data !== "Erro"){history.push('/lista')}
    }


  function handlecpf(e){
    setCpf(e.target.value);
  }

  function handleNome(e){
    setNome(e.target.value);
  }

  return (
    <div className='pageContainer'>
        <div className='login'>
            <h2>Nome</h2>
            <input className='input' type='text' placeholder='Nome' onChange={handleNome} />
            <h2>Quantidade de paginas</h2>
            <input className='input' type='text' placeholder='CPF' onChange={handlecpf}/>
            <button onClick={doarF} className='button'>
              Doar
            </button>
        </div>
    </div>
  );
}
