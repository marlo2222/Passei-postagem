import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    vus: 10,
    duration: '5s',
    thresholds: {
        checks: ['rate > 0.95']
    }
}

export default function () {
    const BASE_URL = 'http://localhost:8060/postagem/postagem';

    const payload = JSON.stringify({
        aluno: 1,
        comentarios: [
          {
            dataCriacao: "2023-04-22T19:41:42.110Z",
            dataModificacao: "2023-04-22T19:41:42.110Z",
            descricao: "Meu primeiro comentario",
            id: 0,
            postagem: {},
            usuario: 0
          }
        ],
        dataCriacao: "2023-04-22T19:41:42.110Z",
        dataModificacao: "2023-04-22T19:41:42.110Z",
        descicao: "Não tenho interrese",
        disciplina: 0,
        id: 0,
        titulo: "postagem"
    });
    
    const params = {
        headers: {
            'Content-Type': 'application/json',
            Accept: "text/plain"
        }
    }

    const res = http.post(BASE_URL, payload, params);

    check(res, {
        'sucesso ao salvar': (r) => r.status === 200
    });

    sleep(1)
}