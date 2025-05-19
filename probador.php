<?php
$controllers = [
    'UsuarioController' => [
        'getAllUsuarios' => [
            'description' => 'Obtiene todos los usuarios',
            'url' => '/api/usuarios',
            'method' => 'GET',
            'params' => []
        ],
        'getUsuarioById' => [
            'description' => 'Obtiene un usuario por su ID',
            'url' => '/api/usuarios/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'createUsuario' => [
            'description' => 'Crea un nuevo usuario',
            'url' => '/api/usuarios',
            'method' => 'POST',
            'params' => ['dni', 'nombre', 'apellido', 'telefono', 'email', 'permisos']
        ],
        'updateUsuario' => [
            'description' => 'Actualiza un usuario existente',
            'url' => '/api/usuarios/{id}',
            'method' => 'PUT',
            'params' => ['id', 'dni', 'nombre', 'apellido', 'telefono', 'email', 'permisos']
        ],
        'deleteUsuario' => [
            'description' => 'Elimina un usuario por su ID',
            'url' => '/api/usuarios/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],

    'CredencialesController' => [
        'getCredencialesById' => [
            'description' => 'Obtiene credenciales por ID',
            'url' => '/api/credenciales/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'createCredenciales' => [
            'description' => 'Crea nuevas credenciales',
            'url' => '/api/credenciales',
            'method' => 'POST',
            'params' => ['nombreUsuario', 'contrasenaHash', 'usuarioId']
        ],
        'updateCredenciales' => [
            'description' => 'Actualiza credenciales existentes',
            'url' => '/api/credenciales/{id}',
            'method' => 'PUT',
            'params' => ['id', 'nombreUsuario', 'contrasenaHash', 'usuarioId']
        ],
        'deleteCredenciales' => [
            'description' => 'Elimina credenciales por ID',
            'url' => '/api/credenciales/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ],
        'getByNombreUsuario' => [
            'description' => 'Obtiene credenciales por nombre de usuario',
            'url' => '/api/credenciales/usuario/{nombreUsuario}',
            'method' => 'GET',
            'params' => ['nombreUsuario']
        ]
    ],

    'EmpleadoController' => [
        'getAllEmpleados' => [
            'description' => 'Obtiene todos los empleados',
            'url' => '/api/empleados',
            'method' => 'GET',
            'params' => []
        ],
        'getEmpleadoById' => [
            'description' => 'Obtiene un empleado por su ID',
            'url' => '/api/empleados/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'createEmpleado' => [
            'description' => 'Crea un nuevo empleado',
            'url' => '/api/empleados',
            'method' => 'POST',
            'params' => ['usuarioId', 'horasTrabajadas', 'estado']
        ],
        'updateEmpleado' => [
            'description' => 'Actualiza un empleado existente',
            'url' => '/api/empleados/{id}',
            'method' => 'PUT',
            'params' => ['id', 'usuarioId', 'horasTrabajadas', 'estado']
        ],
        'deleteEmpleado' => [
            'description' => 'Elimina un empleado por su ID',
            'url' => '/api/empleados/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],

    'PasajeroController' => [
        'getAllPasajeros' => [
            'description' => 'Obtiene todos los pasajeros',
            'url' => '/api/pasajeros',
            'method' => 'GET',
            'params' => []
        ],
        'getPasajeroById' => [
            'description' => 'Obtiene un pasajero por su ID',
            'url' => '/api/pasajeros/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'createPasajero' => [
            'description' => 'Crea un nuevo pasajero',
            'url' => '/api/pasajeros',
            'method' => 'POST',
            'params' => ['usuarioId', 'estado']
        ],
        'updatePasajero' => [
            'description' => 'Actualiza un pasajero existente',
            'url' => '/api/pasajeros/{id}',
            'method' => 'PUT',
            'params' => ['id', 'usuarioId', 'estado']
        ],
        'deletePasajero' => [
            'description' => 'Elimina un pasajero por su ID',
            'url' => '/api/pasajeros/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],

    'HabitacionController' => [
        'getAllHabitaciones' => [
            'description' => 'Obtiene todas las habitaciones',
            'url' => '/api/habitaciones',
            'method' => 'GET',
            'params' => []
        ],
        'getHabitacionById' => [
            'description' => 'Obtiene una habitación por su ID',
            'url' => '/api/habitaciones/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'getHabitacionByNumero' => [
            'description' => 'Obtiene una habitación por su número',
            'url' => '/api/habitaciones/numero/{numero}',
            'method' => 'GET',
            'params' => ['numero']
        ],
        'getHabitacionesByEstado' => [
            'description' => 'Obtiene habitaciones por estado',
            'url' => '/api/habitaciones/estado/{estado}',
            'method' => 'GET',
            'params' => ['estado']
        ],
        'getHabitacionesByTipo' => [
            'description' => 'Obtiene habitaciones por tipo',
            'url' => '/api/habitaciones/tipo/{tipo}',
            'method' => 'GET',
            'params' => ['tipo']
        ],
        'createHabitacion' => [
            'description' => 'Crea una nueva habitación',
            'url' => '/api/habitaciones',
            'method' => 'POST',
            'params' => [
                'numeroHabitacion', 
                'capacidad', 
                'tipoHabitacion', 
                'estado',
                'servicios[WIFI]',
                'servicios[TV_CABLE]',
                'servicios[AIRE_ACONDICIONADO]',
                'servicios[DESAYUNO]',
                'servicios[CAJA_FUERTE]',
                'servicios[PILETA]',
                'servicios[HIDROMASAJE]'
            ]
        ],
        'updateHabitacion' => [
            'description' => 'Actualiza una habitación existente',
            'url' => '/api/habitaciones/{id}',
            'method' => 'PUT',
            'params' => [
                'id',
                'numeroHabitacion', 
                'capacidad', 
                'tipoHabitacion', 
                'estado',
                'servicios[WIFI]',
                'servicios[TV_CABLE]',
                'servicios[AIRE_ACONDICIONADO]',
                'servicios[DESAYUNO]',
                'servicios[CAJA_FUERTE]',
                'servicios[PILETA]',
                'servicios[HIDROMASAJE]'
            ]
        ],
        'calcularCostoHabitacion' => [
            'description' => 'Calcula el costo total de una habitación por su ID',
            'url' => '/api/habitaciones/{id}/costo',
            'method' => 'GET',
            'params' => ['id']
        ],
        'deleteHabitacion' => [
            'description' => 'Elimina una habitación por su ID',
            'url' => '/api/habitaciones/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],


    'CostoHabitacionController' => [
        'getAllCostosHabitacion' => [
            'description' => 'Obtiene todos los costos de habitación',
            'url' => '/api/costos-habitacion',
            'method' => 'GET',
            'params' => []
        ],
        'getCostoHabitacionById' => [
            'description' => 'Obtiene un costo de habitación por su ID',
            'url' => '/api/costos-habitacion/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'getCostoByTipoHabitacion' => [
            'description' => 'Obtiene costo por tipo de habitación',
            'url' => '/api/costos-habitacion/tipo/{tipo}',
            'method' => 'GET',
            'params' => ['tipo']
        ],
        'createCostoHabitacion' => [
            'description' => 'Crea un nuevo costo de habitación',
            'url' => '/api/costos-habitacion',
            'method' => 'POST',
            'params' => ['tipoHabitacion', 'costo']
        ],
        'updateCostoHabitacion' => [
            'description' => 'Actualiza un costo de habitación existente',
            'url' => '/api/costos-habitacion/{id}',
            'method' => 'PUT',
            'params' => ['id', 'tipoHabitacion', 'costo']
        ],
        'deleteCostoHabitacion' => [
            'description' => 'Elimina un costo de habitación por su ID',
            'url' => '/api/costos-habitacion/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],
    'ServicioController' => [
        'getAllServicios' => [
            'description' => 'Obtiene todos los servicios',
            'url' => '/api/servicios',
            'method' => 'GET',
            'params' => []
        ],
        'getServicioById' => [
            'description' => 'Obtiene un servicio por su ID',
            'url' => '/api/servicios/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'getServicioByNombre' => [
            'description' => 'Obtiene un servicio por su nombre',
            'url' => '/api/servicios/nombre/{nombre}',
            'method' => 'GET',
            'params' => ['nombre']
        ],
        'createServicio' => [
            'description' => 'Crea un nuevo servicio',
            'url' => '/api/servicios',
            'method' => 'POST',
            'params' => ['nombre', 'costo']
        ],
        'updateServicio' => [
            'description' => 'Actualiza un servicio existente',
            'url' => '/api/servicios/{id}',
            'method' => 'PUT',
            'params' => ['id', 'nombre', 'costo']
        ],
        'deleteServicio' => [
            'description' => 'Elimina un servicio por su ID',
            'url' => '/api/servicios/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ],
    'ReservaController' => [
        'getAllReservas' => [
            'description' => 'Obtiene todas las reservas',
            'url' => '/api/reservas',
            'method' => 'GET',
            'params' => []
        ],
        'getReservaById' => [
            'description' => 'Obtiene una reserva por su ID',
            'url' => '/api/reservas/{id}',
            'method' => 'GET',
            'params' => ['id']
        ],
        'getReservasBetweenDates' => [
            'description' => 'Obtiene reservas entre fechas',
            'url' => '/api/reservas/fechas',
            'method' => 'GET',
            'params' => ['inicio', 'fin']
        ],
        'getReservasByPasajero' => [
            'description' => 'Obtiene reservas por pasajero',
            'url' => '/api/reservas/pasajero/{pasajeroId}',
            'method' => 'GET',
            'params' => ['pasajeroId']
        ],
        'getReservasByHabitacion' => [
            'description' => 'Obtiene reservas por habitación',
            'url' => '/api/reservas/habitacion/{habitacionId}',
            'method' => 'GET',
            'params' => ['habitacionId']
        ],
        'getReservasByEstado' => [
            'description' => 'Obtiene reservas por estado',
            'url' => '/api/reservas/estado/{estado}',
            'method' => 'GET',
            'params' => ['estado']
        ],
        'createReserva' => [
            'description' => 'Crea una nueva reserva',
            'url' => '/api/reservas',
            'method' => 'POST',
            'params' => ['pasajeroId', 'empleadoId', 'habitacionId', 'fechaInicio', 'fechaFin', 'estado', 'observaciones']
        ],
        'updateReserva' => [
            'description' => 'Actualiza una reserva existente',
            'url' => '/api/reservas/{id}',
            'method' => 'PUT',
            'params' => ['id', 'pasajeroId', 'empleadoId', 'habitacionId', 'fechaInicio', 'fechaFin', 'estado', 'observaciones']
        ],
        'deleteReserva' => [
            'description' => 'Elimina una reserva por su ID',
            'url' => '/api/reservas/{id}',
            'method' => 'DELETE',
            'params' => ['id']
        ]
    ]
];

$selectedController = $_POST['controller'] ?? null;
$selectedMethod = $_POST['method'] ?? null;
$response = null;

if ($_SERVER['REQUEST_METHOD'] === 'POST' && isset($_POST['execute'])) {
    $baseUrl = 'http://localhost:8080'; // Cambia esto por tu URL base
    $urlTemplate = $controllers[$selectedController][$selectedMethod]['url'];
    $url = $baseUrl . $urlTemplate;
    
    $params = [];
    foreach ($controllers[$selectedController][$selectedMethod]['params'] as $param) {
        if (isset($_POST[$param])) {
            $params[$param] = $_POST[$param];
        }
    }
    
    $method = $controllers[$selectedController][$selectedMethod]['method'];
    
    // Reemplazar parámetros en la URL
    foreach ($params as $param => $value) {
        if (strpos($url, '{' . $param . '}') !== false) {
            $url = str_replace('{' . $param . '}', $value, $url);
            unset($params[$param]);
        }
    }
    
    $ch = curl_init();
    
    if ($method === 'GET' && !empty($params)) {
        $url .= '?' . http_build_query($params);
    }
    
    curl_setopt($ch, CURLOPT_URL, $url);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    
    if ($method === 'POST' || $method === 'PUT') {
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
        curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($params));
        curl_setopt($ch, CURLOPT_HTTPHEADER, [
            'Content-Type: application/json',
            'Content-Length: ' . strlen(json_encode($params))
        ]);
    } elseif ($method === 'DELETE') {
        curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'DELETE');
    }
    
    $response = curl_exec($ch);
    $httpCode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
    curl_close($ch);
    
    $response = [
        'status' => $httpCode,
        'response' => json_decode($response, true)
    ];
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Probador de API Hotel</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 800px; margin: 0 auto; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        select, input { width: 100%; padding: 8px; box-sizing: border-box; }
        button { padding: 10px 15px; background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .response { margin-top: 20px; padding: 15px; border: 1px solid #ddd; background-color: #f9f9f9; }
        .param-fields { margin-top: 15px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Probador de API Hotel</h1>
        
        <form method="post">
            <div class="form-group">
                <label for="controller">Controlador:</label>
                <select id="controller" name="controller" onchange="this.form.submit()">
                    <option value="">Seleccione un controlador</option>
                    <?php foreach ($controllers as $controllerName => $methods): ?>
                        <option value="<?= $controllerName ?>" <?= $selectedController === $controllerName ? 'selected' : '' ?>>
                            <?= $controllerName ?>
                        </option>
                    <?php endforeach; ?>
                </select>
            </div>
            
            <?php if ($selectedController): ?>
                <div class="form-group">
                    <label for="method">Método:</label>
                    <select id="method" name="method" onchange="this.form.submit()">
                        <option value="">Seleccione un método</option>
                        <?php foreach ($controllers[$selectedController] as $methodName => $methodInfo): ?>
                            <option value="<?= $methodName ?>" <?= $selectedMethod === $methodName ? 'selected' : '' ?>>
                                <?= $methodName ?> - <?= $methodInfo['description'] ?>
                            </option>
                        <?php endforeach; ?>
                    </select>
                </div>
            <?php endif; ?>
            
            <?php if ($selectedController && $selectedMethod): ?>
                <div class="param-fields">
                    <h3>Parámetros:</h3>
                    <?php foreach ($controllers[$selectedController][$selectedMethod]['params'] as $param): ?>
                        <div class="form-group">
                            <label for="<?= $param ?>"><?= $param ?>:</label>
                            <input type="text" id="<?= $param ?>" name="<?= $param ?>" 
                                   value="<?= $_POST[$param] ?? '' ?>">
                        </div>
                    <?php endforeach; ?>
                    
                    <button type="submit" name="execute">Ejecutar</button>
                </div>
            <?php endif; ?>
        </form>
        
        <?php if ($response): ?>
            <div class="response">
                <h3>Respuesta:</h3>
                <p><strong>Estado HTTP:</strong> <?= $response['status'] ?></p>
                <pre><?= json_encode($response['response'], JSON_PRETTY_PRINT) ?></pre>
            </div>
        <?php endif; ?>
    </div>
</body>
</html>