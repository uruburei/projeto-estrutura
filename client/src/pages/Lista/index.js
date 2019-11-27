import React,{useState,useEffect} from 'react';
import './style.css';
import axios from 'axios';

export default function Lista({history}) {
    const[user,setUser]=useState({});
    const[lista,setLista]=useState([]);
    const[userLista,setUserLista]=useState([])
    const[procurar,setProcurar]=useState('');
    useEffect(()=>{
        async function getinfo(){
            const userlocal = JSON.parse( await localStorage.getItem('BibliotecaFC'))
            
            const response = await axios.post('http://localhost:3333/cliente/login',{
                cpf:userlocal.cpf
            })
            setUser(response.data)
            setUserLista(response.data.livros2 !== undefined?response.data.livros2:[])
            getLista();
        }getinfo()
    },[])

    function doar(){
        history.push('/doar')
    }

    async function getUser(){
        const response = await axios.post('http://localhost:3333/cliente/login',{
            cpf:user.cpf
        })
        setUser(response.data)
        setUserLista(response.data.livros2)
        await localStorage.setItem('BibliotecaFC',JSON.stringify(response.data))
    }

    async function getLista(){
        const response = await axios.get('http://localhost:3333/livro')
        setLista(response.data)
    }

    async function procurarF(){
        const response = await axios.post(`http://localhost:3333/livro/procurar`,{
            nome:procurar
        })
        setLista([response.data])
    }

    function handleProcurar(e){
        setProcurar(e.target.value)
    }

    async function ordenar(){
        const response = await axios.get('http://localhost:3333/livro/orde/')
        setLista(response.data)
    }

    async function pegar(nome){
        const response = await axios.post(`http://localhost:3333/cliente/livro/${nome}`,{
            cpf:user.cpf
        })
        setUser(response.data)
        setUserLista(response.data.livros2)
        getLista()
    }

    async function devolver(nome){
        const response = await axios.post(`http://localhost:3333/cliente/livro/delete/${nome}`,{
            cpf:user.cpf
        })
        console.log(user.cpf)
        setUser(response.data)
        
        setUserLista(response.data.livros2 === undefined ?[]:response.data.livros2)
        getLista()
    }

    function sair(){
        localStorage.clear()
        history.push('/')
    }
  return (
    <div className='pageContainer'>
        <div className='main'>
            <div className='navbar'>
                <h2>
                    B
                </h2>
                <button onClick={()=>sair()} className='button red'>
                    Sair
                </button>
            </div>
            <div className='lista'>
                <div className='headerList'>
                    <input type='text' className='input lista' placeholder='Procurar livro' onChange={handleProcurar} />
                    <button onClick={procurarF} className='button procurar'>
                        Procurar
                    </button>
                </div>
                <div className='listaMain'>
                    <button onClick={ordenar} className='button ordenar'>
                        ordenar
                    </button>
                    <button onClick={doar} className='button ordenar'>
                        Doar
                    </button>
                    <div className='containerList'>
                        {lista.map((item,i)=>(
                            <div key={i} className='item'>
                                <div className='textContainer'>
                                    <p>
                                        Nome: {item.nome} <br/>
                                    </p>
                                    <p>
                                        Paginas: {item.quantidadepaginas}<br/>
                                    </p>
                                </div>
                                <button onClick={()=>pegar(item.nome)} className='button pegar'>
                                    Pegar
                                </button>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <div className='perfil'>
                <div className='perfilHeader'>
                    <h2>
                        {user.nome}
                    </h2>
                    <h4>
                        {user.endereco}
                    </h4>
                    <h4>
                        {user.cpf}
                    </h4>
                </div> 
                <div className='meus'>
                    <h5 className='meusLivros'>
                        Meus livros
                    </h5>
                    <div>
                    <div className='containerList perfillista'>
                        {userLista.map((item,i)=>(
                            <div key={i} className='item itemperfil'>
                                <div className='textContainer'>
                                    <p>
                                        Nome: {item.nome} <br/>
                                    </p>
                                    <p>
                                        Paginas: {item.quantidadepaginas}<br/>
                                    </p>
                                </div>
                                <button onClick={()=>{devolver(item.nome)}} className='button devolver'>
                                    devolver
                                </button>
                            </div>
                        ))}
                        
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
  );
}
