import {getPLCData,tempUltimoValor,getQmValue} from './ZonaA1/app.js';
import {getData,tempUltimoValue,getQm} from './ZonaA2/index.js'


const ctx = document.getElementById('myChart');

async function createChart() {
  const { values, timeStamp } = await getPLCData();
  const { values2 } = await getData();

  new Chart(ctx, {
    type: 'line',
    data: {
        labels: timeStamp,
        datasets: [
          {
            label: 'Zona A1',
            data: values,
            borderWidth: 1
          },
          {
            label: 'Zona A2',
            data: values2,
            borderWidth: 1
          }
        ]
      },
    options: {
      scales: {
        y: {
          beginAtZero: true
        },
        x: {
          ticks: {
            callback: function (value, index, values) {
              // Si el índice es divisible por 60, mostrar la etiqueta
              if (index % 120 === 0) {
                const date = new Date(timeStamp[index]);
                return  date.getHours();

              }
            }
          }
        }
      }
    }
  });
}

createChart()
setTimeout(() => {
    location.reload()
},30000)