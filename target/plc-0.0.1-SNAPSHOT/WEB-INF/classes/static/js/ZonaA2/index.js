export async function getData() {
  const request = await fetch("/api/ZonaA2", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const data = await request.json();
  const values2 = data.map(obj => obj.value);

  return { values2 };
}

export async function tempUltimoValue(){
    const {values2} = await getData();
    const valuesArray = Object.values(values2);
    const ultimoValor = parseFloat(valuesArray[valuesArray.length - 1]);

    const tempValue = document.getElementById("tempValue2")
        tempValue.innerText = ultimoValor;
}


export async function getQm() {
  const request = await fetch("/api/ZonaA2/QM2", {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const data = await request.json();
  const values = data.map(obj => obj.value);

  const valueQM = document.getElementById("valueQM2")
  valueQM.innerText = values
}


tempUltimoValue()
getQm();
