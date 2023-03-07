export async function getPLCData() {
  const request = await fetch("/api/ZonaA1", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json',
    },
  });
  const data = await request.json();
  const values = data.map(obj => obj.value);
  const timeStamp = data.map(obj => obj.serverTimestamp)
  return { values, timeStamp };
}

export async function tempUltimoValor(){
    const {values} = await getPLCData();
    const valuesArray = Object.values(values);
    const ultimoValor = parseFloat(valuesArray[valuesArray.length - 1]);

    const tempValue = document.getElementById("tempValue")
    tempValue.innerText = ultimoValor;

}


export async function getQmValue() {
  const request = await fetch("/api/ZonaA1/QM1", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const data = await request.json();
  const values = data.map(obj => obj.value);
  const valueQM = document.getElementById("valueQM")
  valueQM.innerText = values

}




tempUltimoValor()
getQmValue();
